<template>
  <div class="property-list-result">
    <div class="row">
      <div class="col-xs-6">
        <div class="property-result-summary">Kết quả <b>1 - 15</b> trong <b>121.913</b></div>
      </div>
      <div class="col-xs-6">
        <div class="property-filter-control">
          <ul>
            <li><i class="fas fa-caret-down"></i>Mặc định</li>
            <li><i class="fas fa-list-ul"></i>Danh sách</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ResultList'
}
</script>

<style scoped>
.property-list-result {
  /* Thêm các kiểu CSS của bạn tại đây */
}
.property-filter-control ul {
  list-style-type: none;
  padding: 0;
}
.property-filter-control li {
  display: inline;
  margin-right: 10px;
}
</style>
