<template>
  <div class="home">
    <h1>Which of my pets do you prefer ?</h1>

    <div class="md-layout md-gutter md-alignment-top-center"
         v-if="pets.length > 0">
      <div class="md-layout-item pet-image">
        <md-card>
          <md-card-media-cover md-solid>
            <md-card-media md-ratio="4:3">
              <img v-bind:src="getImageUrl(pets[0].id)" />
            </md-card-media>

            <md-card-area>
              <md-card-header>
                <span class="md-title">{{ pets[0].name }}</span>
                <span class="md-subhead">{{ pets[0].description }}</span>
              </md-card-header>
              <md-card-actions>
                <md-button @click="vote(pets[0])">Vote</md-button>
              </md-card-actions>
            </md-card-area>
          </md-card-media-cover>
        </md-card>
      </div>

      <div class="md-layout-item pet-image">
        <md-card>
          <md-card-media-cover md-solid>
            <md-card-media md-ratio="4:3">
              <img v-bind:src="getImageUrl(pets[1].id)" />
            </md-card-media>

            <md-card-area>
              <md-card-header>
                <span class="md-title">{{ pets[1].name }}</span>
                <span class="md-subhead">{{ pets[1].description }}</span>
              </md-card-header>
              <md-card-actions>
                <md-button @click="vote(pets[1])">Vote</md-button>
              </md-card-actions>

            </md-card-area>
          </md-card-media-cover>
        </md-card>
      </div>
    </div>

    <div class="md-layout md-gutter md-alignment-top-center"
         v-if="error">
      <h2 class="md-accent">
        Error getting data to display ... Try to refresh !
      </h2>
    </div>

    <div class="md-layout md-gutter md-alignment-top-center debug">

      <div class="md-layout-item md-size-100 md-caption"
           v-if="frontHostName">Front hostname : {{frontHostName}}</div>
      <div class="md-layout-item md-size-100 md-caption"
           v-if="backHostName">Back hostname : {{backHostName}}
      </div>
    </div>

    <md-dialog :md-active.sync="showAlert">
      <md-dialog-title>Thanks for your vote !</md-dialog-title>

      <md-dialog-actions>
        <md-button class="md-primary"
                   @click="close()">Close</md-button>
        <md-button class="md-primary"
                   @click="reload()">Another vote ?</md-button>
      </md-dialog-actions>
    </md-dialog>

  </div>
</template>

<script>
// @ is an alias to /src
import { HTTP, baseURL } from "@/http-constants";

export default {
  name: "home",
  data() {
    return {
      pets: [],
      error: false,
      showAlert: false,
      frontHostName: undefined,
      backHostName: undefined
    };
  },
  methods: {
    getImageUrl: function(petId) {
      return baseURL + "pets/" + petId + "/image";
    },
    vote: function() {
      this.showAlert = true;
    },
    close: function() {
      this.showAlert = false;
    },
    reload: function() {
      this.showAlert = false;
      this.initPets();
    },
    initPets: function() {
      HTTP.get("/pets/rnd2")
        .then(response => {
          console.log("reponse : ", response);
          this.pets = response.data;
        })
        .catch(response => {
          console.error("ERROR : ", response);
          this.error = true;
        });
      HTTP.get("/pets/").then(response => {
        console.log("headers ? ", response.headers);
        this.backHostName = response.data;
        this.frontHostName = response.headers["x-petrate-front"];
      });
    }
  },
  created() {
    this.initPets();
  }
};
</script>

<style lang="scss">
img {
  width: 500px;
}
.pet-image {
  max-width: 500px;
}
h2.md-accent {
  color: red;
}
.debug {
  margin-top: 50px;
}
.md-card {
  border: black solid 5px;
}
</style>