<template id="global-loader">
  <v-overlay :value="globalLoader.active" app
             :z-index="999">
    <v-progress-linear style="width: 300px" rounded indeterminate color="primary"></v-progress-linear>
  </v-overlay>
</template>

<script>
let globalLoader = {active: false};
Vue.component("global-loader", {
  template: '#global-loader',
  data: function () {
    return {
      globalLoader: globalLoader
    }
  }
})
</script>