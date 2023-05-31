function getSalesList(params) {
    return $axios({
        url: '/sales/page',
        method: 'get',
        params
    })
}

// 修改---启用禁用接口

// 新增---添加员工
function addSales(params) {
    return $axios({
        url: '/sales/add',
        method: 'post',
        data: {...params}
    })
}

// 修改---添加员工
function editSales(params) {
    return $axios({
        url: '/sales/update',
        method: 'put',
        data: {...params}
    })
}

// 修改页面反查详情接口
function querySalesById(id) {
    return $axios({
        url: `/sales/${id}`,
        method: 'get'
    })
}

function deleteSalesById(id) {
    return $axios({
        url: `/sales/${id}`,
        method: 'delete'
    })
}