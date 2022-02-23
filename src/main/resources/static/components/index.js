window.onload = () => {
    new Vue({
        el: '#index-app',
        template: '#index-app_tpl',
        data: function () {
            return {
                loginOverlay: false,
                minifyNavigation: true,
                activeNavigationItem: activeNavigationItem,
                showUserMenu: false,
                footerYear: new Date().getFullYear(),
                footerText: "bookIt by Pascal Harreuther",
                navigationItems: [
                    {
                        icon: 'fa-solid fa-home',
                        text: 'Dashboard',
                        link: paths.dashboard
                    },
                    {
                        icon: 'fa-solid fa-user-graduate',
                        text: 'Seminars',
                        link: paths.seminars
                    },
                    {
                        icon: 'fa-solid fa-calendar-days',
                        text: 'Seminar administration',
                        link: paths.administration
                    },
                    {
                        icon: 'fa-solid fa-users-gear',
                        text: 'User management',
                        link: paths.userManagement
                    },
                    {
                        icon: 'fa-solid fa-chalkboard-user',
                        text: 'Seminars (leadership)',
                        link: paths.leadership
                    }
                ],
                loginData: {username: "", password: ""},
                showLoginPassword: false,
                loginUserLoading: false
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
            resetLoginData: function (){
                this.loginData = {username: "", password: ""};
            }
        },
        watch: {
           loginOverlay: function (){
               if(this.loginOverlay){
                   this.resetLoginData();
               }
           }
        },
        created: function (){

        },
        computed: {

        },
        mounted: function () {

        }
    });
}