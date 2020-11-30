import Vue from 'vue'
import Router from 'vue-router'
import login from "@/view/login";
import Main from '@/view/main'
Vue.use(Router)

export default new Router({
  routes:[
    {
      path:'/login',
      name:'login',// 路由名称
      component:login// 组件名称
    },
    {
      path: '/main',
      name:'main',
      component: Main
    }
  ]
})
