<template id="index-dashboard-tpl"
          @update-active-navigation-item="updateActiveNavigationItem">
  <v-container fluid color="primary">
    <h2 style="color:#888" class="mb-2">Dashboard</h2>
    <v-card mx-auto>
      <v-card-title>
        <span>Seminarname</span>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-text>
        <v-row>
          <v-col cols="4">12.04.2022 - 15.04.2022</v-col>
          <v-col cols="4" color="success--text">2/18</v-col>
          <v-col cols="4"></v-col>
        </v-row>
      </v-card-text>
      <v-card-actions>
        <v-btn @click="show = !show">
          <span>More Informations</span>
        </v-btn>
      </v-card-actions>
      <v-expand-transition>
        <div v-show="show = !show">
          testtext
        </div>
      </v-expand-transition>
    </v-card>
  </v-container>
</template>