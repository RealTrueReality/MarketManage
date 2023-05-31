function getPurchaseList(params) {
    return $axios({
        url: '/purchase/page',
        method: 'get',
        params
    })
}

// 修改---启用禁用接口

// 新增---添加员工
function addPurchase(params) {
    return $axios({
        url: '/purchase/add',
        method: 'post',
        data: {...params}
    })
}

// 修改---添加员工
function editPurchase(params) {
    return $axios({
        url: '/purchase/update',
        method: 'put',
        data: {...params}
    })
}

// 修改页面反查详情接口
function queryPurchaseById(id) {
    return $axios({
        url: `/purchase/${id}`,
        method: 'get'
    })
}

function deletePurchaseById(id) {
    return $axios({
        url: `/purchase/${id}`,
        method: 'delete'
    })
}