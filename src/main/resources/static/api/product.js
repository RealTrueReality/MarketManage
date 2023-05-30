
function getProductList (params) {
  return $axios({
    url: '/product/page',
    method: 'get',
    params
  })
}

// 修改---启用禁用接口

// 新增---添加员工
function addProduct (params) {
  return $axios({
    url: '/product/add',
    method: 'post',
    data: { ...params }
  })
}

// 修改---添加员工
function editProduct (params) {
  return $axios({
    url: '/product/update',
    method: 'put',
    data: { ...params }
  })
}

// 修改页面反查详情接口
function queryProductById (id) {
  return $axios({
    url: `/product/${id}`,
    method: 'get'
  })
}
function deleteProductById (id) {
  return $axios({
    url: `/product/${id}`,
    method: 'delete'
  })
}