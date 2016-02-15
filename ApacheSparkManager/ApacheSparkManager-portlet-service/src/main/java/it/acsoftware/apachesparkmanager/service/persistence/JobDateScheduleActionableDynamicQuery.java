package it.acsoftware.apachesparkmanager.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;
import it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class JobDateScheduleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public JobDateScheduleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(JobDateScheduleLocalServiceUtil.getService());
        setClass(JobDateSchedule.class);

        setClassLoader(it.acsoftware.apachesparkmanager.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("jobDateScheduleId");
    }
}
