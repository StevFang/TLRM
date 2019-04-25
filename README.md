# TLRM
Tables Logic Relation Manager

--module introduce

--tlr-model
support po and dto.

--tlr-core
support dao and base operate service.
dependence tlr-model module

--tlr-cdc
support capture the database change than async notify consumers.
dependence tlr-core module

--tlr-biz
support biz operation for tlr-api and tlr-web.
dependence tlr-core module

--tlr-api
support api ability to others.

--tlr-web
support view to user operate this system.
