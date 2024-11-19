<template>
  <div class="widget">
    <!-- Nút mũi tên -->
    <div class="toggle-button" @click="toggleExpand">
      <span>
        {{ isExpanded ? "Đóng" : "Bộ Lọc Tìm Kiếm" }}
        <i
          :class="isExpanded ? 'fas fa-chevron-up' : 'fas fa-chevron-down'"
        ></i>
        
      </span>
    </div>

    <!-- Nội dung bảng lọc -->
    <div v-if="isExpanded" class="filter-content">
      <!-- Bộ lọc Quận -->
      <div class="filter-group">
        <h5>Chọn Quận</h5>
        <select v-model="selectedDistrict" class="form-select">
          <option value="">Tất cả</option>
          <option
            v-for="district in districts"
            :key="district"
            :value="district"
          >
            {{ district }}
          </option>
        </select>
      </div>

      <!-- Bộ lọc Tỉnh/Thành -->
      <div class="filter-group">
        <h5>Chọn Tỉnh/Thành</h5>
        <select v-model="selectedProvince" class="form-select">
          <option value="">Tất cả</option>
          <option
            v-for="province in provinces"
            :key="province"
            :value="province"
          >
            {{ province }}
          </option>
        </select>
      </div>

      <!-- Bộ lọc Khoảng Giá -->
      <div class="filter-group">
        <h5>Khoảng Giá (VNĐ)</h5>
        <div class="input-group">
          <input
            type="number"
            v-model="priceRange.min"
            placeholder="Từ"
            class="form-control"
          />
          <span class="input-group-text">-</span>
          <input
            type="number"
            v-model="priceRange.max"
            placeholder="Đến"
            class="form-control"
          />
        </div>
      </div>

      <!-- Bộ lọc Khoảng Diện Tích -->
      <div class="filter-group">
        <h5>Khoảng Diện Tích (m²)</h5>
        <div class="input-group">
          <input
            type="number"
            v-model="areaRange.min"
            placeholder="Từ"
            class="form-control"
          />
          <span class="input-group-text">-</span>
          <input
            type="number"
            v-model="areaRange.max"
            placeholder="Đến"
            class="form-control"
          />
        </div>
      </div>

      <!-- Nút Áp Dụng -->
      <div class="filter-group">
        <button class="btn btn-primary mt-3" @click="applyFilters">
          Áp dụng
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchAdvance",
  data() {
    return {
      isExpanded: false, // Trạng thái hiển thị bảng
      selectedDistrict: "",
      selectedProvince: "",
      priceRange: { min: null, max: null },
      areaRange: { min: null, max: null },
      districts: ["Quận 1", "Quận 2", "Quận 3", "Quận 7", "Quận 9"], // Thay bằng dữ liệu thực tế
      provinces: ["Hà Nội", "TP. Hồ Chí Minh", "Đà Nẵng", "Bắc Ninh"], // Thay bằng dữ liệu thực tế
    };
  },
  methods: {
    toggleExpand() {
      this.isExpanded = !this.isExpanded; // Thay đổi trạng thái ẩn/hiện
    },
    applyFilters() {
      const filters = {
        district: this.selectedDistrict,
        province: this.selectedProvince,
        priceRange: this.priceRange,
        areaRange: this.areaRange,
      };

      console.log("Filters applied:", filters);

      // Truyền filters qua API hoặc Vue Router
      this.$emit("apply-filters", filters);
    },
  },
};
</script>

<style scoped>
.widget {
  border: 1px solid #ddd;
  padding: 16px;
  border-radius: 8px;
}

.toggle-button {
  cursor: pointer;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-weight: bold;
  margin-bottom: 8px;
}

.toggle-button i {
  margin-left: 8px;
}

.filter-content {
  margin-top: 8px;
}

.filter-group {
  margin-bottom: 1rem;
}

.input-group {
  display: flex;
  align-items: center;
}

.input-group-text {
  background-color: #f8f9fa;
}

.btn {
  width: 100%;
}
</style>
