create table GondorPharmacy_Drug (
	uuid_ VARCHAR(75) null,
	drugId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	drugName VARCHAR(75) null,
	drugType VARCHAR(75) null,
	drugQuantity DOUBLE
);