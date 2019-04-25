package com.ddmh.condition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 列变更记录查询条件
 *
 * @author FBin
 * @version 2019/4/10 9:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("ColumnAuditRecordCondition")
public class ColumnAuditRecordCondition extends BasePageCondition implements Serializable {

    private String columnId;

}
