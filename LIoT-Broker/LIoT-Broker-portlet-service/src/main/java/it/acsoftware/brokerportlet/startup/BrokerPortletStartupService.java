package it.acsoftware.brokerportlet.startup;

import it.acsoftware.brokerportlet.service.BrokerLocalServiceUtil;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class BrokerPortletStartupService extends SimpleAction {
	private Log logger = LogFactoryUtil
			.getLog(BrokerPortletStartupService.class);

	@Override
	public void run(String[] ids) throws ActionException {
		for (int i = 0; i < ids.length; i++) {
			long companyId = Long.parseLong(ids[i]);
			initBrokerServices(companyId);
		}
	}

	private void initBrokerServices(long companyId) {
		BrokerLocalServiceUtil.startupBrokerServices(companyId);
	}

}
