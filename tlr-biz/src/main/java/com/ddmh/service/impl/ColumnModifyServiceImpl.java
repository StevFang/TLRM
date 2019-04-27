package com.ddmh.service.impl;

import com.ddmh.constant.FieldDefinitionConstant;
import com.ddmh.dto.ColumnAuditRecordDto;
import com.ddmh.dto.ColumnDto;
import com.ddmh.dto.FieldDefinitionDto;
import com.ddmh.mapper.ColumnMapper;
import com.ddmh.service.ColumnModifyService;
import com.ddmh.service.spi.ColumnAuditRecordService;
import com.ddmh.utils.CommonUtils;
import com.ddmh.utils.DataConvertUtils;
import com.ddmh.utils.DateUtils;
import com.ddmh.utils.TlrExceptionAssertUtil;
import com.ddmh.vo.ColumnVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 字段变更 service interface
 *
 * @author FBin
 * @version 2019/4/10 9:06
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ColumnModifyServiceImpl implements ColumnModifyService {

    @Autowired
    private ColumnMapper columnMapper;

    @Autowired
    private ColumnAuditRecordService columnAuditRecordService;

    @Override
    public void create(ColumnVo columnVo) {
        ColumnDto columnDto = convertToDto(columnVo);
        columnMapper.save(columnDto);
    }

    @Override
    public void update(ColumnVo columnVo) {
        ColumnDto newColumnDto = convertToDto(columnVo);
        ColumnDto oldColumnDto = columnMapper.findById(columnVo.getId());

        TlrExceptionAssertUtil.assertNotNull(oldColumnDto, "待更新的数据未获取到！");

        List<ColumnAuditRecordDto> columnAuditRecordDtoList = Lists.newArrayList();
        compareAndEnrichColumnAuditRecordDtoList(newColumnDto, oldColumnDto, columnAuditRecordDtoList);

        columnMapper.update(newColumnDto);
        columnAuditRecordService.batchSave(columnAuditRecordDtoList);
    }

    @Override
    public void deleteById(String id) {
        columnMapper.deleteById(id);
    }

    /**
     * vo to dto
     *
     * @param columnVo
     * @return
     */
    private ColumnDto convertToDto(ColumnVo columnVo){
        return ColumnDto.builder()
                .id(CommonUtils.getId())
                .dbName(columnVo.getDbName())
                .tableName(columnVo.getTableName())
                .columnName(columnVo.getColumnName())
                .columnDesc(columnVo.getColumnDesc())
                .columnLength(columnVo.getColumnLength())
                .columnType(columnVo.getColumnType())
                .indexFlag(columnVo.getIndexFlag())
                .indexType(columnVo.getIndexType())
                .indexDesc(columnVo.getIndexDesc())
                .mappingType(columnVo.getMappingType())
                .nullAble(columnVo.getNullAble())
                .primaryKeyFlag(columnVo.getPrimaryKeyFlag())
                .requireFlag(columnVo.getRequireFlag())
                .relatedTable(columnVo.getRelatedTable())
                .relatedTableField(columnVo.getRelatedTableField())
                .build();
    }

    /**
     * 比较并获取变更信息
     *
     * @param newColumnDto
     * @param oldColumnDto
     * @param columnAuditRecordDtoList
     */
    private void compareAndEnrichColumnAuditRecordDtoList(ColumnDto newColumnDto,
                                                          ColumnDto oldColumnDto,
                                                          List<ColumnAuditRecordDto> columnAuditRecordDtoList) {
        List<FieldDefinitionDto> fieldDefinitionDtoList = FieldDefinitionConstant.getColumnDtoFieldDefinitionDtoList();
        for(FieldDefinitionDto fieldDefinitionDto : fieldDefinitionDtoList){
            String fieldName = fieldDefinitionDto.getFieldName().substring(0, 1).toUpperCase()
                    + fieldDefinitionDto.getFieldName().substring(1);
            try {
                Method newMethod = newColumnDto.getClass().getMethod("get" + fieldName);
                Object newValue = newMethod.invoke(newColumnDto);

                Method oldMethod = oldColumnDto.getClass().getMethod("get" + fieldName);
                Object oldValue = oldMethod.invoke(oldColumnDto);

                if(newValue == null && oldValue == null){
                    continue;
                }

                if(newValue != null && !newValue.equals(oldValue)){
                    String columnName = oldColumnDto.getColumnName();
                    // update sql to redesign
                    ColumnAuditRecordDto columnAuditRecordDto = ColumnAuditRecordDto.builder()
                            .id(CommonUtils.getId())
                            .columnId(oldColumnDto.getId())
                            .updateMeta(columnName)
                            .before(DataConvertUtils.getString(newValue))
                            .after(DataConvertUtils.getString(oldValue))
                            .createOn(DateUtils.now())
                            .updateSql("")
                            .build();
                    columnAuditRecordDtoList.add(columnAuditRecordDto
                    );
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
