function getSupplierList(params) {
    return $axios({
        url: '/supplier/page',
        method: 'get',
        params
    })
}

// 修改---启用禁用接口

// 新增---添加员工
function addSupplier(params) {
    return $axios({
        url: '/supplier/add',
        method: 'post',
        data: {...params}
    })
}

// 修改---添加员工
function editSupplier(params) {
    return $axios({
        url: '/supplier/update',
        method: 'put',
        data: {...params}
    })
}

// 修改页面反查详情接口
function querySupplierById(id) {
    return $axios({
        url: `/supplier/${id}`,
        method: 'get'
    })
}

function deleteSupplierById(id) {
    return $axios({
        url: `/supplier/${id}`,
        method: 'delete'
    })
}