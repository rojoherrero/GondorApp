create index IX_61340273 on GOndorApp_Drug (drugType[$COLUMN_LENGTH:75$]);
create index IX_D79A07F9 on GOndorApp_Drug (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_69C638BB on GOndorApp_Drug (uuid_[$COLUMN_LENGTH:75$], groupId);