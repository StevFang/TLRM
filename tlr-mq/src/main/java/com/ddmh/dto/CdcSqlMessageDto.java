package com.ddmh.dto;

import com.ddmh.dto.ddl.*;
import com.ddmh.dto.dml.DeleteDataDto;
import com.ddmh.dto.dml.InsertDataDto;
import com.ddmh.dto.dml.UpdateDataDto;
import com.ddmh.enums.CdcSqlMessageTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cdc sql message dto
 *
 * @author fbin
 * @version 2019/5/1 0001 23:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CdcSqlMessageDto {

    private CdcSqlMessageTypeEnum messageType;

    private AlterTableDto alterTableDto;
    private CreateIndexDto createIndexDto;
    private CreateTableDto createTableDto;
    private DropIndexDto dropIndexDto;
    private DropTableDto dropTableDto;
    private RenameTableDto renameTableDto;

    private DeleteDataDto deleteDataDto;
    private InsertDataDto insertDataDto;
    private UpdateDataDto updateDataDto;

}
