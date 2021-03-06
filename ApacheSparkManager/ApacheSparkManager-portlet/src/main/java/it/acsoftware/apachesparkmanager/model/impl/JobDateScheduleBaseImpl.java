package it.acsoftware.apachesparkmanager.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import it.acsoftware.apachesparkmanager.model.JobDateSchedule;
import it.acsoftware.apachesparkmanager.service.JobDateScheduleLocalServiceUtil;

/**
 * The extended model base implementation for the JobDateSchedule service. Represents a row in the &quot;ApacheSparkManager_JobDateSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JobDateScheduleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobDateScheduleImpl
 * @see it.acsoftware.apachesparkmanager.model.JobDateSchedule
 * @generated
 */
public abstract class JobDateScheduleBaseImpl extends JobDateScheduleModelImpl
    implements JobDateSchedule {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a job date schedule model instance should use the {@link JobDateSchedule} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            JobDateScheduleLocalServiceUtil.addJobDateSchedule(this);
        } else {
            JobDateScheduleLocalServiceUtil.updateJobDateSchedule(this);
        }
    }
}
