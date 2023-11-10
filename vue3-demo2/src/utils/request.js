import axios from 'axios'
import router from '../router/router'

// 创建 Axios 实例 设置一些基础属性
const request = axios.create({
  baseURL:'http://localhost:8080/ssm',
  timeout: 10000
})

// 添加请求拦截器
request.interceptors.request.use(
  config => {
    //可以前置设置，例如请求头token等
    config.headers.head1 = 'ceshi-head1'
    return config
  },
  error => {
    return Promise.reject(error)
  }
)
// 添加响应拦截器
request.interceptors.response.use(
  response => {
   return response
  },
  error => {
    if (error.response.status === 404) {
        //到404页面
        router.push('/404');
    }else{
        // 其他情况 返回一个promise    
        return Promise.reject(error)
    }
  }
)
//对外暴漏axios实例。
export default request