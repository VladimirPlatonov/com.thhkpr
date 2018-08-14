<template>
    <div class="row">
        <div class="col-md-4">
            Menu
            <router-link to="/">Home</router-link>
            <router-link to="/things/">Things</router-link>
        </div>
        <div class="col-md-6">
            <router-view></router-view>
        </div>
    </div>
</template>

<script>
    import "bootstrap/dist/css/bootstrap.min.css";
    import "../pages/Home.vue"
    import "../pages/things/ListThings.vue"
    import "../pages/NotFound.vue"


    export default {
    };
</script>
