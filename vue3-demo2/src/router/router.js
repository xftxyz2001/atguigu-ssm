//路由配置的js
//1.引入路由依赖
import {createRouter,createWebHashHistory} from 'vue-router'

//引入vue组件
import List from '../components/List.vue'
import AddItem from '../components/AddItem.vue'
import Error404 from '../components/Error404.vue'
import Error from '../components/Error.vue'

//2.创建路由对象,并且设置路由配置 (首页,404,error页)
const router = createRouter({
    history:createWebHashHistory(),
    routes:[
        {
            path:'/',
            component: List
        },
        {
            path: '/404',
            component: Error404
        },
        {
            path:'/error',
            component:Error
        },
        {
            path:'/add',
            component:AddItem
        }
    ]
})

//3.对外暴漏路由对象
export default router