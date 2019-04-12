
var myTableHandler = $('#myTable').bootstrapTable({
    url: '/column/list',
    method: 'post',
    toolbar: "#toolbar",
    sidePagination: "server",
    striped: true, // 是否显示行间隔色
    search : "true",
    uniqueId: "ID",
    pageSize: "5",
    pagination: true, // 是否分页
    sortable: true, // 是否启用排序
    columns: [
        {
            field: 'id',
            align: 'center',
            width: 80,
            formatter: function (value) {
                return '<input type="checkbox" data_id="'+value+'" />';
            }
        },
        {
            field: "dbName",
            title: "数据库"
        },
        {
            field: "tableName",
            title: "数据表"
        },
        {
            field: 'columnName',
            title: '字段名'
        },
        {
            field: 'columnType',
            title: '字段类型'
        },
        {
            field: "columnLength",
            title: "字段长度"
        },
        {
            field: "mappingType",
            title: "映射类型"
        },
        {
            field: 'columnDesc',
            title: '字段描述'
        },
        {
            field: "requiredFlag",
            title: "必填"
        },
        {
            field: 'nullAble',
            title: "为空"
        },
        {
            field: "primaryKeyFlag",
            title: "是否主键"
        },
        {
            field: "indexFlag",
            title: "是否创建索引"
        },
        {
            field: "indexType",
            title: "索引类型"
        },
        {
            field: "indexDesc",
            title: "索引描述信息"
        },
        {
            field: 'relatedTable',
            title: "关联表"
        },
        {
            field: 'relatedTableField',
            title: "关联字段"
        },
        {
            field: 'id',
            title: '操作',
            width: 120,
            align: 'center',
            formatter: function (value) {
                var result = "<a href='javascript:;' class='btn btn-xs blue' onclick='editViewById(" + value + ")' title='编辑'><i class='fa fa-pencil fa-lg'></i></a>";
                result += "<a href='javascript:;' class='btn btn-xs red' onclick='deleteByIds(" + value + ")' title='删除'><i class='fa fa-trash-o fa-lg'></i></a>";
                return result;
            }
        }
    ]
});

function editViewById(id) {

    myTableHandler.bootstrapTable('refresh');
}

function deleteByIds(id) {

    myTableHandler.bootstrapTable('refresh');
}