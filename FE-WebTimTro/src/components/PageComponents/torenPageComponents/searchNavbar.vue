<template>
  <div class="search-bar-child">
    <div class="container">
      <div class="row">
        <div class="col-xs-4 col-sm-12 col-md-4 col-lg-4">
          <div class="input-group keywords">
            <div class="input-group-prepend">
              <span class="input-group-text color-search" id="basic-addon1">
                <i class="fas fa-search" aria-hidden="true"></i>
              </span>
            </div>
            <input
              style="height: 40px; border: none"
              type="text"
              class="form-control bg-light color-search"
              placeholder="Từ khóa, Đường, Quận, Dự án hoặc địa danh ..."
            />
          </div>
        </div>
        <div class="col-lg-2 col-xs-4 col-sm-6 col-md-4" style="height: 50px">
          <div class="form-group keywords">
            <select
              class="form-control"
              name="calc_shipping_provinces"
              required=""
            >
              <option value="">Tỉnh / Thành phố</option>
            </select>
          </div>
        </div>
        <div class="col-lg-2 col-xs-4 col-sm-6 col-md-4" style="height: 50px">
          <div class="form-group keywords">
            <select
              class="form-control"
              name="calc_shipping_district"
              required=""
            >
              <option value="">Quận / Huyện</option>
            </select>
          </div>
        </div>
        <div class="col-lg-2 col-sm-6" style="height: 50px">
          <div class="form-group keywords">
            <select class="form-control" required="">
              <option value="">Giá từ</option>
              <option value="">1.000.000</option>
              <option value="">2.000.000</option>
              <option value="">3.000.000</option>
            </select>
          </div>
        </div>
        <div class="col-lg-2 col-sm-6" style="height: 50px">
          <div class="form-group keywords">
            <select class="form-control" required="">
              <option value="">Giá max</option>
              <option value="">3.000.000</option>
              <option value="">4.000.000</option>
              <option value="">5.000.000</option>
              <option value="">6.000.000</option>
            </select>
          </div>
        </div>
        <input class="billing_address_1" name="" type="hidden" value="" />
        <input class="billing_address_2" name="" type="hidden" value="" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchNavbar",
};
</script>
