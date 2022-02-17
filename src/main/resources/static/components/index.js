window.onload = () => {
    new Vue({
        el: '#index-app',
        template: '#index-app_tpl',
        data: function () {
            return {
                isLoaderActive: true,
                loginOverlay: false,
                minifyNavigation: true,
                activeNavigationItem: 0,
                navigationItems: [
                    {
                        icon: 'fa-solid fa-home',
                        text: 'Dashboard',
                        link: paths.dashboard
                    },
                    {
                        icon: 'fa-solid fa-user-graduate',
                        text: 'Seminars (participants)',
                        link: paths.participants
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
                loginFormHasErrors: false,
                loginRules: {
                    required: value => !!value || 'Required.',
                    email: value => {
                        const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
                        return pattern.test(value) || 'Invalid e-mail.'
                    },
                    min: v => v.length >= 4 || 'Min 4 characters',
                },
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
            closeLoginOverlay: function (){
                console.log("closeLoginOverlay")
                if(!this.loginOverlay){return;}
                console.log("closeLoginOverlay")
                this.resetLoginData();
                this.loginOverlay = false;
            },
            resetLoginData: function (){
                this.loginData = {user: "", password: ""};
            },
            loginUser: function (){
                this.loginUserLoading = true;
                this.loginFormHasErrors = false;

                Object.keys(this.loginForm).forEach(f => {
                    if (!this.loginForm[f]) this.loginFormHasErrors = true

                    this.$refs[f].validate(true)
                })
                if(!this.loginFormHasErrors) {
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
                }
                this.loginUserLoading = false;
            }
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
            loginForm() {
                return {
                    user: this.loginData.user,
                    password: this.loginData.password,
                }
            }
        },
        mounted: function () {
            this.isLoaderActive = false;
        }
    });
}