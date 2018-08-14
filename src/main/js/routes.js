import Vue from 'vue'
import Router from 'vue-router'

//import HelloWorld from '@/components/HelloWorld'
//import ListThings from "./pages/things/ListThings.vue";

import ListThings from "./pages/things/ListThings.vue";
import AddProduct from "./pages/things/AddProduct.vue";
import EditProduct from "./pages/things/EditProduct.vue";
import DeleteProduct from "./pages/things/DeleteProduct.vue";
import NotFound from "./pages/NotFound.vue";
import Home from "./pages/Home.vue";

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/things/',
            component: ListThings
        }
        /*,
            {
                path: '/product/add',
                component: AddProduct
            },
            {
                path: '/product/edit/:id',
                component: EditProduct
            },
            {
                path: '/product/delete/:id',
                component: DeleteProduct
            },
            {
                path: '*',
                component: NotFound
            }*/

    ]
})
