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
                loginData: {user: "", password: ""},
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
                this.loginData = {user: "", password: ""};
            },
            loginUser: function (){
                this.loginUserLoading = true;

                console.log("LoginUser: user=" + this.loginData.user + " password=" + this.loginData.password);
                let data = this.loginData;
                let self = this;
                axios.post(paths.login, data)
                    .then(function successCallback(response) {
                            self.loginUserLoading = false;
                        console.log("LoginUser: success");
                        }, function errorCallback(response) {
                            self.loginUserLoading = false;
                        console.log("LoginUser: error");
                        }
                    )
                this.loginUserLoading = false;
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
            loginForm() {
                return {
                    user: this.loginData.user,
                    password: this.loginData.password,
                }
            }
        },
        mounted: function () {

        }
    });
}