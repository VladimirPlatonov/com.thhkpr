<template>
    <div>
        <router-link to="/things/add" class="btn btn-light">Create new thing</router-link>
        <div>Products</div>
        <table class="table table-bordered">
            <tr>
                <th>THINGS_ID</th>
                <th>THINGS_NAME</th>
                <th>&nbsp;</th>
            </tr>
            <template v-for="thing in things">
                <tr>
                    <td>{{thing.id}}</td>
                    <td>{{thing.name}}</td>
                    <td>
                        <router-link :to="{path:'/things/edit/'+thing.id}" class="btn btn-light">Edit</router-link>
                    </td>
                    <td>
                        <router-link :to="{path:'/things/delete/'+thing.id}" class="btn btn-danger">Delete</router-link>
                    </td>
                </tr>
            </template>
        </table>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        data() {
            return {
                things: []
            }
        },
        mounted() {
            axios.get('/api/things/')
                .then((response) => {
                    this.things = response.data.things;
                });
        }
    }
</script>

