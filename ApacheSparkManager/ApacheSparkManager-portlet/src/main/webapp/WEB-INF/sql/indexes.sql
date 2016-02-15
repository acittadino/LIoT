create index IX_B8191941 on ApacheSparkManager_JobDateSchedule (companyId);

create index IX_678EC48D on ApacheSparkManager_JobEventSchedule (companyId);
create index IX_2BC00008 on ApacheSparkManager_JobEventSchedule (companyId, eventName);
create unique index IX_2D4D5081 on ApacheSparkManager_JobEventSchedule (companyId, eventName, jarName, mainClass);

create index IX_D23A0521 on ApacheSparkManager_jobDateSchedule (companyId);

create index IX_918B54AD on ApacheSparkManager_jobEventSchedule (companyId);
create unique index IX_F7E1BE8 on ApacheSparkManager_jobEventSchedule (companyId, eventName);