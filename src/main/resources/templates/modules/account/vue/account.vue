<template id="index-account-tpl"
          @update-active-navigation-item="updateActiveNavigationItem">
  <v-container fluid color="primary">
    <h2 style="color:#888" class="mb-2">Account</h2>
    <v-card mx-auto>
      <v-card-text>
        <v-row>
          <v-col>
            <v-text-field
                v-model="userModel.username"
                label="Username"
            ></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-text-field
                v-model="userModel.email"
                label="Email"
            ></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-text-field
                v-model="userModel.firstName"
                label="First Name"
            ></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-text-field
                v-model="userModel.lastName"
                label="Last Name"
            ></v-text-field>
          </v-col>
        </v-row>
      </v-card-text>
      <v-card-actions>
        <v-btn @click="saveUser">
          <span>Save</span>
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>