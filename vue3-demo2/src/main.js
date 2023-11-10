import { createApp } from 'vue'
import App from './App.vue'
// elementPlus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// 路由
import router from './router/router.js'


//  应用组件
let app =createApp(App)
app.use(ElementPlus)
app.use(router)

app.mount('#app')
