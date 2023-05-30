
function getCustomerList (params) {
  return $axios({
    url: '/customer/page',
    method: 'get',
    params
  })
}

// 修改---启用禁用接口

// 新增---添加员工
function addCustomer (params) {
  return $axios({
    url: '/customer/add',
    method: 'post',
    data: { ...params }
  })
}

// 修改---添加员工
function editCustomer (params) {
  return $axios({
    url: '/customer/update',
    method: 'put',
    data: { ...params }
  })
}

// 修改页面反查详情接口
function queryCustomerById (id) {
  return $axios({
    url: `/customer/${id}`,
    method: 'get'
  })
}
function deleteCustomerById (id) {
  return $axios({
    url: `/customer/${id}`,
    method: 'delete'
  })
}