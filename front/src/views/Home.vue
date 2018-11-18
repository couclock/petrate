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

            </md-card-area>
          </md-card-media-cover>
        </md-card>
      </div>

      <div class="md-layout-item md-size-5 md-alignment-center-center">
        <div class="md-layout-item">
          <h2>vs</h2>
        </div>
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

  </div>
</template>

<script>
// @ is an alias to /src
import { HTTP } from '@/http-constants';

export default {
  name: 'home',
  data() {
    return {
      pets: [],
      error: false
    };
  },
  methods: {
    getImageUrl: function(petId) {
      return 'http://localhost:8080/pets/' + petId + '/image';
    }
  },
  created() {
    HTTP.get('/pets/rnd2')
      .then(response => {
        this.pets = response.data;
      })
      .catch(response => {
        console.error('ERROR : ', response);
        this.error = true;
      });
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
</style>