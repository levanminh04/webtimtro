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
              style="height: 40px;border: none;" 
              type="text" 
              class="form-control bg-light color-search" 
              placeholder="Từ khóa, Đường, Quận, Dự án hoặc địa danh ..." 
            />
          </div>
        </div>
        <div class="col-lg-2 col-xs-4 col-sm-6 col-md-4" style="height: 50px;">
          <div class="form-group keywords">
            <select class="form-control" name="calc_shipping_provinces" required>
              <option value="">Tỉnh / Thành phố</option>
            </select>
          </div>
        </div>
        <div class="col-lg-2 col-xs-4 col-sm-6 col-md-4" style="height: 50px;">
          <div class="form-group keywords">
            <select class="form-control" name="calc_shipping_district" required>
              <option value="">Quận / Huyện</option>
            </select>
          </div>
        </div>
        <div class="col-lg-2 col-sm-6" style="height: 50px;">
          <div class="form-group keywords">
            <select class="form-control" required>
              <option value="">Giá từ</option>
              <option value="">1.000.000</option>
              <option value="">2.000.000</option>
              <option value="">3.000.000</option>
            </select>
          </div>
        </div>
        <div class="col-lg-2 col-sm-6" style="height: 50px;">
          <div class="form-group keywords">
            <select class="form-control" required>
              <option value="">Giá max</option>
              <option value="">3.000.000</option>
              <option value="">4.000.000</option>
              <option value="">5.000.000</option>
              <option value="">6.000.000</option>
            </select>
          </div>
        </div>
        <input class="billing_address_1" name="" type="hidden" value="">
        <input class="billing_address_2" name="" type="hidden" value="">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SearchNavbar',
  data() {
    return {};
  },
  methods: {
    layzyLoadCity() {
      let address_2 = localStorage.getItem('address_2_saved');
      if (address_2) {
        this.$nextTick(() => {
          const $districtSelect = this.$el.querySelector('select[name="calc_shipping_district"]');
          const $address2Input = this.$el.querySelector('input.billing_address_2');
          $districtSelect.querySelectorAll('option').forEach(option => {
            if (option.text === address_2) {
              option.selected = true;
            }
          });
          $address2Input.value = address_2;
        });
      }

      let district = localStorage.getItem('district');
      if (district) {
        this.$nextTick(() => {
          const $districtSelect = this.$el.querySelector('select[name="calc_shipping_district"]');
          $districtSelect.innerHTML = district;
          $districtSelect.addEventListener('change', () => {
            const target = $districtSelect.options[$districtSelect.selectedIndex];
            target.selected = true;
            $districtSelect.querySelectorAll('option').forEach(option => {
              if (option !== target) option.selected = false;
            });
            address_2 = target.text;
            const $address2Input = this.$el.querySelector('input.billing_address_2');
            $address2Input.value = address_2;
            district = $districtSelect.innerHTML;
            localStorage.setItem('district', district);
            localStorage.setItem('address_2_saved', address_2);
          });
        });
      }

      const $provinceSelect = this.$el.querySelector('select[name="calc_shipping_provinces"]');
      let stc = '';
      c.forEach((i, e) => {
        e += 1;
        stc += `<option value="${e}">${i}</option>`;
      });
      $provinceSelect.innerHTML = `<option value="">Tỉnh / Thành phố</option>${stc}`;

      let address_1 = localStorage.getItem('address_1_saved');
      if (address_1) {
        this.$nextTick(() => {
          $provinceSelect.querySelectorAll('option').forEach(option => {
            if (option.text === address_1) {
              option.selected = true;
            }
          });
          const $address1Input = this.$el.querySelector('input.billing_address_1');
          $address1Input.value = address_1;
        });
      }

      $provinceSelect.addEventListener('change', () => {
        const selectedIndex = $provinceSelect.selectedIndex - 1;
        let str = '';
        const r = $provinceSelect.value;
        if (r !== '') {
          arr[selectedIndex].forEach(el => {
            str += `<option value="${el}">${el}</option>`;
          });
          this.$el.querySelector('select[name="calc_shipping_district"]').innerHTML = `<option value="">Quận / Huyện</option>${str}`;
          address_1 = $provinceSelect.options[$provinceSelect.selectedIndex].text;
          district = this.$el.querySelector('select[name="calc_shipping_district"]').innerHTML;
          localStorage.setItem('address_1_saved', address_1);
          localStorage.setItem('district', district);
        } else {
          this.$el.querySelector('select[name="calc_shipping_district"]').innerHTML = `<option value="">Quận / Huyện</option>`;
          district = this.$el.querySelector('select[name="calc_shipping_district"]').innerHTML;
          localStorage.setItem('district', district);
          localStorage.removeItem('address_1_saved');
        }
      });
    }
  },
  mounted() {
    this.layzyLoadCity();
  }
}
</script>

<style scoped>
.search-bar-child {
  /* Thêm các kiểu CSS của bạn tại đây */
}
</style>
