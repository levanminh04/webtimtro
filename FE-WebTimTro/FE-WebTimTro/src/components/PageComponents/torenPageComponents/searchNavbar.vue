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
              style="height: 40px; border: none;"
              type="text"
              class="form-control bg-light color-search"
              placeholder="Từ khóa, Đường, Quận, Dự án hoặc địa danh ..."
            />
          </div>
        </div>
        <div class="col-lg-2 col-xs-4 col-sm-6 col-md-4" style="height: 50px;">
          <div class="form-group keywords">
            <select class="form-control" name="calc_shipping_provinces" required="">
              <option value="">Tỉnh / Thành phố</option>
            </select>
          </div>
        </div>
        <div class="col-lg-2 col-xs-4 col-sm-6 col-md-4" style="height: 50px;">
          <div class="form-group keywords">
            <select class="form-control" name="calc_shipping_district" required="">
              <option value="">Quận / Huyện</option>
            </select>
          </div>
        </div>
        <div class="col-lg-2 col-sm-6" style="height: 50px;">
          <div class="form-group keywords">
            <select class="form-control" required="">
              <option value="">Giá từ</option>
              <option value="">1.000.000</option>
              <option value="">2.000.000</option>
              <option value="">3.000.000</option>
            </select>
          </div>
        </div>
        <div class="col-lg-2 col-sm-6" style="height: 50px;">
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
        <input class="billing_address_1" name="" type="hidden" value="">
        <input class="billing_address_2" name="" type="hidden" value="">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SearchNavbar',
  methods: {
    layzyLoadCity() {
      if (localStorage.getItem('address_2_saved')) {
        const address_2 = localStorage.getItem('address_2_saved');
        $('select[name="calc_shipping_district"] option').each(function () {
          if ($(this).text() === address_2) {
            $(this).attr('selected', '');
          }
        });
        $('input.billing_address_2').attr('value', address_2);
      }

      if (localStorage.getItem('district')) {
        const district = localStorage.getItem('district');
        $('select[name="calc_shipping_district"]').html(district);
        $('select[name="calc_shipping_district"]').on('change', function () {
          const target = $(this).children('option:selected');
          target.attr('selected', '');
          $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected');
          const address_2 = target.text();
          $('input.billing_address_2').attr('value', address_2);
          localStorage.setItem('district', $('select[name="calc_shipping_district"]').html());
          localStorage.setItem('address_2_saved', address_2);
        });
      }

      $('select[name="calc_shipping_provinces"]').each(function () {
        const $this = $(this);
        let stc = '';
        c.forEach((i, e) => {
          e += 1;
          stc += `<option value="${e}">${i}</option>`;
          $this.html('<option value="">Tỉnh / Thành phố</option>' + stc);

          if (localStorage.getItem('address_1_saved')) {
            const address_1 = localStorage.getItem('address_1_saved');
            $('select[name="calc_shipping_provinces"] option').each(function () {
              if ($(this).text() === address_1) {
                $(this).attr('selected', '');
              }
            });
            $('input.billing_address_1').attr('value', address_1);
          }

          $this.on('change', function () {
            const i = $this.children('option:selected').index() - 1;
            let str = '';
            const r = $this.val();
            if (r !== '') {
              arr[i].forEach((el) => {
                str += `<option value="${el}">${el}</option>`;
                $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>' + str);
              });

              const address_1 = $this.children('option:selected').text();
              const district = $('select[name="calc_shipping_district"]').html();
              localStorage.setItem('address_1_saved', address_1);
              localStorage.setItem('district', district);

              $('select[name="calc_shipping_district"]').on('change', function () {
                const target = $(this).children('option:selected');
                target.attr('selected', '');
                $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected');
                const address_2 = target.text();
                $('input.billing_address_2').attr('value', address_2);
                localStorage.setItem('district', $('select[name="calc_shipping_district"]').html());
                localStorage.setItem('address_2_saved', address_2);
              });
            } else {
              $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>');
              localStorage.setItem('district', $('select[name="calc_shipping_district"]').html());
              localStorage.removeItem('address_1_saved');
            }
          });
        });
      });
    },
  },
  mounted() {
    this.layzyLoadCity();
  },
};
</script>

<style scoped>
/* Thêm các style tùy chọn nếu cần */
</style>
