package it.acsosftware.brokerportlet.util;

import java.io.File;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

public class ResourceLocator {
	private Log logger = LogFactoryUtil.getLog(ResourceLocator.class);
	private static ResourceLocator instance;

	private ResourceLocator() {

	}

	public static synchronized ResourceLocator getInstance() {
		if (instance == null)
			instance = new ResourceLocator();
		return instance;
	}

	public Folder getOrCreateDocumentLibraryAttributesFolder(long companyId,
			long groupId, long parentFolderId, String folderName,
			String folderDescription) {
		User defaultUser = null;
		try {
			defaultUser = CompanyLocalServiceUtil.getCompany(companyId)
					.getDefaultUser();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}

		Folder attributeFolder = null;
		try {
			attributeFolder = DLAppLocalServiceUtil.getFolder(groupId, parentFolderId,
					folderName);
		} catch (PortalException e) {
			logger.info("Folder do not exists, creating...");
		} catch (SystemException e) {
			logger.info("Folder do not exists, creating...");
		}

		if (attributeFolder == null) {
			try {
				attributeFolder = DLAppLocalServiceUtil.addFolder(
						defaultUser.getUserId(), groupId, parentFolderId,
						folderName, folderDescription, new ServiceContext());

			} catch (Exception e) {
				logger.error(e);
				return null;
			}
		}
		return attributeFolder;
	}

	public String addFileToDocumentLibrary(long companyId, long groupId,
			long userId, Folder folder, File f, String fileName, String mimeType) {
		if (f != null && f.exists() && folder != null) {
			FileEntry fileEntry = null;
			try {
				fileEntry = DLAppLocalServiceUtil.getFileEntry(groupId,
						folder.getFolderId(), fileName);
			} catch (Exception e) {
				logger.debug("No file found...creating");
			}

			if (fileEntry != null) {
				try {
					DLAppLocalServiceUtil.deleteFileEntry(fileEntry
							.getFileEntryId());
				} catch (Exception e) {
					logger.debug("Impossible to remove file:" + f.getName());
				}
			}

			try {
				fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, groupId,
						folder.getFolderId(), f.getName(), mimeType, fileName,
						"", "", f, new ServiceContext());
				return fileEntry.getUuid();
			} catch (Exception e) {
				return "";
			}
		}
		return null;
	}

	public String getDocumentLibraryFileUrl(FileEntry fileEntry,
			ThemeDisplay themeDisplay) {
		if (fileEntry != null) {
			fileEntry = fileEntry.toEscapedModel();
			long folderId = fileEntry.getFolderId();
			String title = fileEntry.getTitle();
			String fileUrl = themeDisplay.getPortalURL()
					+ themeDisplay.getPathContext() + "/documents/"
					+ themeDisplay.getScopeGroupId() + "//" + folderId + "//"
					+ HttpUtil.encodeURL(HtmlUtil.unescape(title));
			return fileUrl;
		}
		return "";
	}

}

