<template>
    <div class="search-bar-box">
      <h2>Đúng nhà, đúng giá, đúng thời điểm</h2>
      <div class="search-bar">
        <div class="container-search">
          <div class="search">
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text color-search" id="basic-addon1"><i class="fas fa-search"></i></span>
              </div>
              <input type="text" class="form-control bg-light color-search" placeholder="Từ khóa, Đường, Quận, Dự án hoặc địa danh ..." aria-label="Username" aria-describedby="basic-addon1" />
              <div class="input-group-prepend">
                <span class="input-group-text color-search btn-search" id="basic-addon1">Tìm kiếm</span>
              </div>
            </div>
          </div>
          <div class="search-filter">
            <div class="select-1">
              <select class="form-control" name="calc_shipping_provinces" required="">
                <option value="">Tỉnh / Thành phố</option>
              </select>
            </div>
            <div class="select-2">
              <select class="form-control" name="calc_shipping_district" required="">
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
            <input class="billing_address_1" name="" type="hidden" value="">
            <input class="billing_address_2" name="" type="hidden" value="">
          </div>
        </div> 
      </div>
    </div>
  </template>
  
  <script>
  import $ from 'jquery'; // Đảm bảo jQuery được cài đặt trong dự án
  
  export default {
    name: 'SearchBar',
    methods: {
      layzyLoadCity() {
        let address_1, address_2, district;
        if ((address_2 = localStorage.getItem('address_2_saved'))) {
          $('select[name="calc_shipping_district"] option').each(function() {
            if ($(this).text() === address_2) {
              $(this).attr('selected', '');
            }
          });
          $('input.billing_address_2').attr('value', address_2);
        }
  
        if ((district = localStorage.getItem('district'))) {
          $('select[name="calc_shipping_district"]').html(district);
          $('select[name="calc_shipping_district"]').on('change', function() {
            const target = $(this).children('option:selected');
            target.attr('selected', '');
            $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected');
            address_2 = target.text();
            $('input.billing_address_2').attr('value', address_2);
            district = $('select[name="calc_shipping_district"]').html();
            localStorage.setItem('district', district);
            localStorage.setItem('address_2_saved', address_2);
          });
        }
  
        $('select[name="calc_shipping_provinces"]').each(function() {
          const $this = $(this);
          let stc = '';
          const c = ["Hà Nội", "TP Hồ Chí Minh"]; // Ví dụ về danh sách tỉnh/thành phố
          const arr = [["Quận 1", "Quận 2"], ["Quận 3", "Quận 4"]]; // Ví dụ về danh sách quận/huyện theo tỉnh/thành phố
  
          c.forEach((i, e) => {
            e += 1;
            stc += `<option value="${e}">${i}</option>`;
          });
  
          $this.html('<option value="">Tỉnh / Thành phố</option>' + stc);
  
          if ((address_1 = localStorage.getItem('address_1_saved'))) {
            $('select[name="calc_shipping_provinces"] option').each(function() {
              if ($(this).text() === address_1) {
                $(this).attr('selected', '');
              }
            });
            $('input.billing_address_1').attr('value', address_1);
          }
  
          $this.on('change', function() {
            const i = $this.children('option:selected').index() - 1;
            let str = '';
            const r = $this.val();
            if (r !== '') {
              arr[i].forEach(el => {
                str += `<option value="${el}">${el}</option>`;
              });
              $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>' + str);
              address_1 = $this.children('option:selected').text();
              district = $('select[name="calc_shipping_district"]').html();
              localStorage.setItem('address_1_saved', address_1);
              localStorage.setItem('district', district);
              $('select[name="calc_shipping_district"]').on('change', function() {
                const target = $(this).children('option:selected');
                target.attr('selected', '');
                $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected');
                address_2 = target.text();
                $('input.billing_address_2').attr('value', address_2);
                district = $('select[name="calc_shipping_district"]').html();
                localStorage.setItem('district', district);
                localStorage.setItem('address_2_saved', address_2);
              });
            } else {
              $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>');
              district = $('select[name="calc_shipping_district"]').html();
              localStorage.setItem('district', district);
              localStorage.removeItem('address_1_saved');
            }
          });
        });
      }
    },
    mounted() {
      this.layzyLoadCity();
    }
  };
  </script>
  
  