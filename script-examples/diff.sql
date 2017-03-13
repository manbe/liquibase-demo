<?xml version="1.1" encoding="UTF-8" standalone="no"?>
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog" xmlns:ext="http://www.liquibase.org/xml/ns/dbchangelog-ext" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.5.xsd">
    <changeSet author="root (generated)" id="1489439139784-1" objectQuotingStrategy="QUOTE_ALL_OBJECTS">
        <createTable tableName="angry_devops">
            <column name="angry" type="INT"/>
        </createTable>
    </changeSet>
    <changeSet author="root (generated)" id="1489439139784-2" objectQuotingStrategy="QUOTE_ALL_OBJECTS">
        <createTable tableName="person">
            <column autoIncrement="true" name="id" type="INT">
                <constraints primaryKey="true"/>
            </column>
            <column name="firstname" type="VARCHAR(50)"/>
            <column name="lastname" type="VARCHAR(50)">
                <constraints nullable="false"/>
            </column>
            <column name="state" type="CHAR(2)"/>
            <column name="username" type="VARCHAR(8)"/>
            <column name="nickname" type="VARCHAR(8)"/>
        </createTable>
    </changeSet>
    <changeSet author="root (generated)" id="1489439139784-3" objectQuotingStrategy="QUOTE_ALL_OBJECTS">
        <createTable tableName="state">
            <column name="id" type="CHAR(2)">
                <constraints nullable="false"/>
            </column>
        </createTable>
    </changeSet>
    <changeSet author="root (generated)" id="1489439139784-4" objectQuotingStrategy="QUOTE_ALL_OBJECTS">
        <addPrimaryKey columnNames="id" tableName="state"/>
    </changeSet>
    <changeSet author="root (generated)" id="1489439139784-5" objectQuotingStrategy="QUOTE_ALL_OBJECTS">
        <createIndex indexName="FK_PERSON_STATE" tableName="person">
            <column name="state"/>
        </createIndex>
    </changeSet>
    <changeSet author="root (generated)" id="1489439139784-6" objectQuotingStrategy="QUOTE_ALL_OBJECTS">
        <addForeignKeyConstraint baseColumnNames="state" baseTableName="person" constraintName="FK_PERSON_STATE" deferrable="true" initiallyDeferred="false" onDelete="RESTRICT" onUpdate="RESTRICT" referencedColumnNames="id" referencedTableName="state"/>
    </changeSet>
</databaseChangeLog>
