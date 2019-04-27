# T.L.R.M
##### Title: Tables Logic Relation Manager

## module introduce

#### tlr-model
##### support po and dto.

#### tlr-mq
##### support async notify message.

#### tlr-core
##### support dao and base operate service.
##### dependence: _tlr-model_

#### tlr-biz
##### support biz operation for tlr-api and tlr-web.
##### dependence: _tlr-core_、_tlr_mq_

#### tlr-cdc
##### support capture the database change than async notify consumers.
##### dependence: _tlr-model_、_tlr_mq_

#### tlr-api
##### support api ability to others.
##### dependence: _tlr_biz_

#### tlr-web
##### support view to user operate this system.
##### dependence: _tlr_biz_

##### Thanks every one. Have a good lunch, remember drink a cup of coffee.
