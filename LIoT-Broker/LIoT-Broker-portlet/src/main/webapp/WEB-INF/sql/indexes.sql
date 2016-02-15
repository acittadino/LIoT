create index IX_97F999CC on LiOT_Broker (companyId);
create unique index IX_1EB4608B on LiOT_Broker (companyId, name);

create index IX_845291F3 on LiOT_BrokerMessageListener (brokerId);
create index IX_15CA5082 on LiOT_BrokerMessageListener (brokerId, type_);
create index IX_C511BC5D on LiOT_BrokerMessageListener (companyId);
create unique index IX_A412925C on LiOT_BrokerMessageListener (companyId, name);