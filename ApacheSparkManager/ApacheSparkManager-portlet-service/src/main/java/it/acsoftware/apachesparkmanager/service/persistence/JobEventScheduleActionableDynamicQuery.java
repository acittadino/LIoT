package it.acsoftware.apachesparkmanager.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.acsoftware.apachesparkmanager.model.JobEventSchedule;
import it.acsoftware.apachesparkmanager.service.JobEventScheduleLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class JobEventScheduleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public JobEventScheduleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(JobEventScheduleLocalServiceUtil.getService());
        setClass(JobEventSchedule.class);

        setClassLoader(it.acsoftware.apachesparkmanager.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("jobEventScheduleId");
    }
}
