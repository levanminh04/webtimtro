<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light nav-desktop">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto logo">
        <li class="nav-item" @click="toHomePage" style="cursor: pointer">
          <a>
            <img
              src="https://png.pngtree.com/template/20191014/ourmid/pngtree-building-and-construction-logo-design-template-image_317780.jpg"
              width="50"
              height="36"
              alt="mogi"
            />
          </a>
          <span>Trang chủ</span>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto menu-top">
        <li class="nav-item ml-2">
          <a class="nav-link" @click="toTorenPage">Tìm thuê</a>
        </li>
        <li class="nav-item ml-2">
          <a class="nav-link" href="./lienhe.html">Liên hệ</a>
        </li>
        <li class="nav-item ml-2">
          <a class="nav-link"><i class="far fa-heart"></i></a>
        </li>
        <li class="nav-item ml-2">
          <a class="nav-link"><i class="far fa-bell"></i></a>
        </li>
        <li class="nav-item ml-2">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
            Đăng tin
          </button>
        </li>
      </ul>
    </div>
  </nav>
</template>
  
  <script>
export default {
  name: "Navbar",
  methods: {
    toTorenPage() {
      this.$router.push("/search");
    },
    toHomePage() {
      window.location.reload();
    },
  },
};
</script>
  
 