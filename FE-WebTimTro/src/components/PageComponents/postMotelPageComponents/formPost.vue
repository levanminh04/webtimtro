<template>
  <fieldset class="border p-3">
    <legend class="w-auto px-2">Nhập thông tin nhà của bạn</legend>

    <!-- Tên toà nhà -->
    <div class="form-floating mb-3">
      <input
        type="text"
        class="form-control"
        id="title"
        placeholder="Nhập Tên Toà Nhà"
        v-model="title"
      />
      <label for="title">Nhập Tên Toà Nhà</label>
    </div>

    <!-- Số nhà -->
    <div class="form-floating mb-3">
      <input
        type="number"
        class="form-control"
        id="houseNumber"
        placeholder="Số nhà"
        v-model="houseNumber"
      />
      <label for="houseNumber">Số nhà</label>
    </div>

    <!-- Tỉnh/Thành Phố, Quận/Huyện, Phường/Xã, Đường -->
    <div class="container">
      <div class="row">
        <div class="col-6 col-sm-3">
          <select
            class="form-select mb-3"
            v-model="province"
            @change="onProvinceChange"
          >
            <option value="" selected>Chọn tỉnh thành</option>

            <option
              v-for="province in provinces"
              :key="province.code"
              :value="province.code"
            >
              {{ province.name }}
            </option>
          </select>
        </div>
        <div class="col-6 col-sm-3">
          <select
            class="form-select mb-3"
            v-model="district"
            @change="onDistrictChange"
            :disabled="!districts.length"
          >
            <option value="" disabled selected>Chọn quận huyện</option>
            <option
              v-for="district in districts"
              :key="district.code"
              :value="district.code"
            >
              {{ district.name }}
            </option>
          </select>
        </div>
        <div class="col-6 col-sm-3">
          <select
            class="form-select mb-3"
            v-model="ward"
            @change="onWardChange"
            :disabled="!wards.length"
          >
            <option selected value="">Chọn phường xã</option>
            <option v-for="ward in wards" :key="ward.code" :value="ward.code">
              {{ ward.name }}
            </option>
          </select>
        </div>
        <div class="col-6 col-sm-3">
          <input
            type="text"
            class="form-control mb-3"
            placeholder="Đường"
            v-model="street"
          />
        </div>
      </div>
    </div>

    <!-- Diện tích -->
    <div class="form-floating mb-3">
      <input
        type="number"
        class="form-control"
        id="area"
        placeholder="Diện tích"
        v-model="area"
      />
      <label for="area">Diện tích (m²)</label>
    </div>

    <!-- Giá thuê -->
    <div class="form-floating mb-3">
      <input
        type="number"
        class="form-control"
        id="price"
        placeholder="Giá thuê"
        v-model="price"
      />
      <label for="price">Giá thuê (VND)</label>
    </div>

    <!-- Nội thất -->
    <div class="form-floating mb-3">
      <input
        type="text"
        class="form-control"
        id="interior"
        placeholder="Nội thất"
        v-model="interior"
      />
      <label for="interior">Nội thất</label>
    </div>

    <!-- Loại hình -->
    <div class="form-floating mb-3">
      <input
        type="text"
        class="form-control"
        id="type"
        placeholder="Loại hình"
        v-model="type"
      />
      <label for="type">Loại hình</label>
    </div>

    <!-- Mô tả chi tiết -->
    <div class="form-floating mb-3">
      <textarea
        class="form-control"
        id="detail"
        placeholder="Mô tả chi tiết"
        v-model="detail"
      ></textarea>
      <label for="detail">Mô tả chi tiết</label>
    </div>

    <!-- Số người tối đa -->
    <div class="form-floating mb-3">
      <input
        type="number"
        class="form-control"
        id="maxPeople"
        placeholder="Số người tối đa"
        v-model="maxPeople"
      />
      <label for="maxPeople">Số người tối đa</label>
    </div>

    <!-- Phần thêm ảnh -->
    <div class="mb-3">
      <label for="images" class="form-label"
        >Chọn ảnh (Bạn có thể chọn nhiều ảnh)</label
      >
      <input type="file" class="form-control" id="formFileMultiple" multiple />
    </div>

    <!-- Các nút đồng ý và huỷ -->
    <div class="d-flex justify-content-end">
      <button type="button" class="btn btn-success me-2" @click="submitForm">
        Đồng ý
      </button>
      <button type="button" class="btn btn-secondary">Huỷ</button>
    </div>
  </fieldset>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      provinces: [],
      districts: [],
      wards: [],
      title: null,
      type: null,
      houseNumber: null,
      ward: "",
      district: "",
      province: "",
      interior: null,
      maxPeople: null,
      detail: null,
      street: null,
      area: null,
      price: null,
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
        this.provinces = response.data;
        console.log(response.data);
      } catch (error) {
        console.error("Error fetching cities:", error);
      }
    },
    async onProvinceChange() {
      this.district = "";
      this.ward = "";
      this.wards = [];
      if (this.province) {
        try {
          const response = await axios.get(
            `https://provinces.open-api.vn/api/p/${this.province}?depth=2`
          );
          this.districts = response.data.districts;
        } catch (error) {
          console.error("Error fetching districts:", error);
        }
      } else {
        this.districts = [];
      }
      for (let item in this.provinces) {
        if (item.code == this.province) {
          this.province = item.name;
        }
      }
      console.log(this.province);
    },
    async onDistrictChange() {
      this.ward = "";
      if (this.district) {
        try {
          const response = await axios.get(
            `https://provinces.open-api.vn/api/d/${this.district}?depth=2`
          );
          this.wards = response.data.wards;
        } catch (error) {
          console.error("Error fetching wards:", error);
        }
      } else {
        this.wards = [];
      }
      for (let item in this.districts) {
        if (item.code == this.district) {
          this.district = item.name;
        }
      }
    },

    async submitForm() {
      const formData = new FormData();
      for (let item of this.provinces) {
        if (item.code == this.province) {
          formData.append("province", item.name);
          break;
        }
      }

      // Lấy tên quận/huyện từ `districts`
      for (let item of this.districts) {
        if (item.code == this.district) {
          formData.append("district", item.name);
          break;
        }
      }

      // Lấy tên phường/xã từ `wards`
      for (let item of this.wards) {
        if (item.code == this.ward) {
          formData.append("ward", item.name);
          break;
        }
      }

      formData.append("title", this.title);
      // formData.append("province", this.province);
      formData.append("maxPeople", this.maxPeople);
      formData.append("houseNumber", this.houseNumber);
      formData.append("street", this.street);
      // formData.append("ward", this.ward);
      // formData.append("district", this.district);
      formData.append("area", this.area);
      formData.append("price", this.price);
      formData.append("interior", this.interior);
      formData.append("maxPeople", this.type);
      formData.append("detail", this.detail);

      const fileImg = document.getElementById("formFileMultiple").files;
      for (let i = 0; i < fileImg.length; i++) {
        formData.append("files", fileImg[i]);
      }
      const token = localStorage.getItem("token");
      console.log(formData);
      try {
        console.log("Token:", token);
        const response = await axios.post(
          "http://localhost:8081/create",
          formData,
          {
            headers: {
              "Content-Type": "multipart/form-data",
              Authorization: `Bearer ${token}`,
            },
          }
        );
        alert("Thành công: " + response.data);
      } catch (error) {
        console.error("Error:", error);
        alert("Đã xảy ra lỗi!");
      }
    },
  },
};
</script>

<style scoped>
.border {
  border: 5px solid #ced4da;
  border-radius: 5px;
}
.legend {
  font-weight: bold;
}
</style>
