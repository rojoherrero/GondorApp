create index IX_F21F955F on GondorPharmacy_Drug (drugType[$COLUMN_LENGTH:75$]);
create index IX_3E9EEE5 on GondorPharmacy_Drug (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_707AEAA7 on GondorPharmacy_Drug (uuid_[$COLUMN_LENGTH:75$], groupId);