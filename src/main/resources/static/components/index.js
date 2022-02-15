window.onload = () => {
    new Vue({
        el: '#index-app',
        template: '#index-app_tpl',
        data: function () {
            return {
                isLoaderActive: true,
            }
        },
        vuetify: new Vuetify({
            icons: {
                iconfont: 'fa'
            },
            theme: {
                themes: {
                    light: vueTheme,
                },
            },
        }),
        methods: {

        },
        watch: {
           /* tfaData: {
                handler(val){
                    this.checkPinRulesValid(val.pin);
                },
                deep: true
            }*/
        },
        created: function (){

        },
        computed: {

        },
        mounted: function () {
            this.isLoaderActive = false;
        }
    });
}