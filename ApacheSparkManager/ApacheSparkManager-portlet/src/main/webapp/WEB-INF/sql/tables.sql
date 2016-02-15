create table ApacheSparkManager_JobDateSchedule (
	jobDateScheduleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	scheduleName VARCHAR(75) null,
	chronExpression VARCHAR(75) null,
	params VARCHAR(75) null,
	jarName VARCHAR(75) null,
	mainClass VARCHAR(75) null,
	active_ BOOLEAN
);

create table ApacheSparkManager_JobEventSchedule (
	jobEventScheduleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventName VARCHAR(75) null,
	params VARCHAR(75) null,
	jarName VARCHAR(75) null,
	mainClass VARCHAR(75) null,
	active_ BOOLEAN
);

create table ApacheSparkManager_jobDateSchedule (
	jobDateScheduleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	chronExpression VARCHAR(75) null,
	params VARCHAR(75) null,
	jarName VARCHAR(75) null,
	mainClass VARCHAR(75) null
);

create table ApacheSparkManager_jobEventSchedule (
	jobEventScheduleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventName VARCHAR(75) null,
	params VARCHAR(75) null,
	jarName VARCHAR(75) null,
	mainClass VARCHAR(75) null
);