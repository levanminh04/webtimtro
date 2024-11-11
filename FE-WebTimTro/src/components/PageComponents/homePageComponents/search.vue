<template>
  <div class="search-bar-box">
    <h2>Đúng nhà, đúng giá, đúng thời điểm</h2>
    <div class="search-bar">
      <div class="container-search">
        <div class="search">
          <div class="input-group mb-3">
            <div class="input-group-prepend">
              <span class="input-group-text color-search" id="basic-addon1"
                ><i class="fas fa-search"></i
              ></span>
            </div>
            <input
              type="text"
              class="form-control bg-light color-search"
              placeholder="Từ khóa, Đường, Quận, Dự án hoặc địa danh ..."
              aria-label="Username"
              aria-describedby="basic-addon1"
            />
            <div class="input-group-prepend">
              <span
                class="input-group-text color-search btn-search"
                id="basic-addon1"
                >Tìm kiếm</span
              >
            </div>
          </div>
        </div>
        <div class="search-filter">
          <div class="select-1">
            <select
              class="form-control"
              name="calc_shipping_provinces"
              required=""
            >
              <option value="">Tỉnh / Thành phố</option>
            </select>
          </div>
          <div class="select-2">
            <select
              class="form-control"
              name="calc_shipping_district"
              required=""
            >
              <option value="">Quận / Huyện</option>
            </select>
          </div>
          <div class="select-3">
            <select class="form-control" required="">
              <option value="">Giá từ</option>
              <option value="">1.000.000</option>
              <option value="">2.000.000</option>
              <option value="">3.000.000</option>
            </select>
          </div>
          <div class="select-4">
            <select class="form-control" required="">
              <option value="">Giá max</option>
              <option value="">3.000.000</option>
              <option value="">4.000.000</option>
              <option value="">5.000.000</option>
              <option value="">6.000.000</option>
            </select>
          </div>
          <input class="billing_address_1" name="" type="hidden" value="" />
          <input class="billing_address_2" name="" type="hidden" value="" />
        </div>
      </div>
    </div>
  </div>
</template>
  
  <script>
import $ from "jquery"; // Đảm bảo jQuery được cài đặt trong dự án

export default {
  name: "SearchBar",
};
</script>
  
  