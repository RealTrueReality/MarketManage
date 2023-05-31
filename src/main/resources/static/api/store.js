function getStoreList(params) {
    return $axios({
        url: '/store/page',
        method: 'get',
        params
    })
}

// 修改---启用禁用接口

// 新增---添加员工
function addStore(params) {
    return $axios({
        url: '/store/add',
        method: 'post',
        data: {...params}
    })
}

// 修改---添加员工
function editStore(params) {
    return $axios({
        url: '/store/update',
        method: 'put',
        data: {...params}
    })
}

// 修改页面反查详情接口
function queryStoreById(id) {
    return $axios({
        url: `/store/${id}`,
        method: 'get'
    })
}

function deleteStoreById(id) {
    return $axios({
        url: `/store/${id}`,
        method: 'delete'
    })
}