<template>
  <div>
    <select v-model="selectedCity" @change="onCityChange">
      <option value="" selected>Chọn tỉnh thành</option>
      <option v-for="city in cities" :key="city.code" :value="city.code">
        {{ city.name }}
      </option>
    </select>

    <select
      v-model="selectedDistrict"
      @change="onDistrictChange"
      :disabled="!districts.length"
    >
      <option value="" selected>Chọn quận huyện</option>
      <option
        v-for="district in districts"
        :key="district.code"
        :value="district.code"
      >
        {{ district.name }}
      </option>
    </select>

    <select
      v-model="selectedWard"
      @change="onWardChange"
      :disabled="!wards.length"
    >
      <option value="" selected>Chọn phường xã</option>
      <option v-for="ward in wards" :key="ward.code" :value="ward.code">
        {{ ward.name }}
      </option>
    </select>

    <h2>{{ result }}</h2>
  </div>
</template>
  
  <script>
import axios from "axios";

export default {
  name: "testPage",
  data() {
    return {
      cities: [],
      districts: [],
      wards: [],
      selectedCity: "",
      selectedDistrict: "",
      selectedWard: "",
      result: "",
    };
  },
  created() {
    this.fetchCities();
  },
  methods: {
    async fetchCities() {
      try {
        const response = await axios.get(
          "https://provinces.open-api.vn/api/?depth=1"
        );
        this.cities = response.data;
      } catch (error) {
        console.error("Error fetching cities:", error);
      }
    },
    async onCityChange() {
      this.selectedDistrict = "";
      this.selectedWard = "";
      this.wards = [];
      if (this.selectedCity) {
        try {
          const response = await axios.get(
            `https://provinces.open-api.vn/api/p/${this.selectedCity}?depth=2`
          );
          this.districts = response.data.districts;
        } catch (error) {
          console.error("Error fetching districts:", error);
        }
      } else {
        this.districts = [];
      }
      this.updateResult();
    },
    async onDistrictChange() {
      this.selectedWard = "";
      if (this.selectedDistrict) {
        try {
          const response = await axios.get(
            `https://provinces.open-api.vn/api/d/${this.selectedDistrict}?depth=2`
          );
          this.wards = response.data.wards;
        } catch (error) {
          console.error("Error fetching wards:", error);
        }
      } else {
        this.wards = [];
      }
      this.updateResult();
    },
    onWardChange() {
      this.updateResult();
    },
    updateResult() {
      if (this.selectedCity && this.selectedDistrict && this.selectedWard) {
        const city = this.cities.find(
          (city) => city.code === this.selectedCity
        ).name;
        const district = this.districts.find(
          (district) => district.code === this.selectedDistrict
        ).name;
        const ward = this.wards.find(
          (ward) => ward.code === this.selectedWard
        ).name;
        this.result = `${city} | ${district} | ${ward}`;
      } else {
        this.result = "";
      }
    },
  },
};
</script>
  
  <style scoped>
select {
  margin-right: 10px;
}
</style>
  