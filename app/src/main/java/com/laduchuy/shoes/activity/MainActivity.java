package com.laduchuy.shoes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.laduchuy.shoes.R;
import com.laduchuy.shoes.Util;
import com.laduchuy.shoes.adapter.AdapterProduct;
import com.laduchuy.shoes.database.DBHelper;
import com.laduchuy.shoes.object.Product;
import com.laduchuy.shoes.object.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "";

    NavigationView navigationView;
    ImageView imgMenu, imgCart, imgSearch, imgSort, imgAvatar;
    EditText edSearch;
    TextView tvName;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;

    AdapterProduct adapterProduct;

    DBHelper dbHelper;

    //@SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMenu = findViewById(R.id.imgMenu);
        imgCart = findViewById(R.id.imgCart);
        imgSearch = findViewById(R.id.imgSearch);
        edSearch = findViewById(R.id.edSearch);
        recyclerView = findViewById(R.id.recyclerview);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer);
        imgSort = findViewById(R.id.imgSort);
        dbHelper = new DBHelper(this);
        navigationView.setItemIconTintList(null);
        View headerView = navigationView.getHeaderView(0);
        imgAvatar = headerView.findViewById(R.id.imgAvatar);
        tvName = headerView.findViewById(R.id.tvUserName);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("login");
        User user = (User) bundle.getSerializable("user");
        Toast.makeText(this, user.getName(), Toast.LENGTH_LONG).show();
        tvName.setText(user.getName());

//        if (dbHelper.getAllProduct().isEmpty()) {
//            dbHelper.insertProduct(new Product(1001, "Giày Sneakers Unisex DOMBA High Point", R.drawable.pro1 + "", "Sử dụng chất liệu da PU và đế làm bằng EVA nhẹ, êm giúp cho bước chân của bạn trở lên thoải mái, dễ chịu khi mang. Đế giày độn chiều cao lên đến 5cm giúp cho dáng bạn trở lên thanh thoát và tự tin hơn", "Trắng", 39, 230000, 3));
//            dbHelper.insertProduct(new Product(1002, "Giày Sneakers Unisex CLAE Bradley", R.drawable.pro1 + "", "Giày Sneakers Unisex NATIVE Ad Cornell", "Đỏ", 39, 330000, 5));
//            dbHelper.insertProduct(new Product(1003, "Giày Sneakers Unisex CLAE Bradley", R.drawable.pro1 + "", "Giày sneaker nam Clae Bradley với thiết kế thời trang sẽ giúp bạn tự tin thể hiện cá tính riêng biệt của mình, đế giày chống mòn, chống trơn trượt. ", "Đỏ", 38, 320000, 4));
//            dbHelper.insertProduct(new Product(1004, "Giày Sneakers Unisex CLAE Bradley", R.drawable.pro1 + "", "Giày Sneakers Unisex Clae Bradley được may từ chất liệu da cao cấp, đường may tỉ mỉ kết hợp thiết kế đơn giản, mang lại phong cách hiện đại và không kém phần nam tính cho phái mạnh. Đế giày có rãnh chống trơn trượt mang đến sự an toàn cho bạn trong suốt quá trình vận động. Sản phẩm dễ dàng phối hợp với nhiều loại trang phục và phụ kiện.", "Đen", 37, 499000, 7));
//            dbHelper.insertProduct(new Product(1005, "Giày Sneakers Unisex CLAE Bradley", R.drawable.pro1 + "", "Giày sneaker nam Clae Bradley với thiết kế thời trang sẽ giúp bạn tự tin thể hiện cá tính riêng biệt của mình, đế giày chống mòn, chống trơn trượt.", "Xanh", 38, 430000, 4));
//            dbHelper.insertProduct(new Product(1006, "Giày Sneakers Nam ADIDAS Court Adapt", R.drawable.pro1 + "", "Nâng tầm phong cách của bạn bên ngoài sân thi đấu. Mẫu giày lấy cảm hứng từ môn quần vợt này có kiểu dáng đẹp mắt được may từ vải dệt kim mềm mại.", "Đen", 39, 220000, 6));
//            dbHelper.insertProduct(new Product(1007, "Giày Sneakers Nam GEOX U Kaula D", R.drawable.pro1 + "", "Giày Sneakers nam GEOX U KAULA D NAPPA+SYNT.LEA WHITE/NAVY sở hữu kiểu dáng thời trang nhưng không kém phần hiện đại.", "Trắng", 39, 230000, 4));
//            dbHelper.insertProduct(new Product(1008, "Giày Sneakers Nam GEOX U Leitan D", R.drawable.pro1 + "", "Giày lười Leitan cho nam với thiết kế như một giày tây nhưng siêu nhẹ và thoáng khí, phù hợp với trang phục hàng ngày: Leitan nâng niu bàn chân với phần mũi giày rộng, không chỉ mang đến sự nhẹ nhàng, thoải mái và phong cách tinh tế trong lớp vải nappa đen.", "Đen", 40, 320000, 7));
//        }
//        Util.products = dbHelper.getAllProduct();

        Util.products.add(new Product(1001, "Giày Sneakers Unisex DOMBA High Point", R.drawable.pro1 + "", "Sử dụng chất liệu da PU và đế làm bằng EVA nhẹ, êm giúp cho bước chân của bạn trở lên thoải mái, dễ chịu khi mang. Đế giày độn chiều cao lên đến 5cm giúp cho dáng bạn trở lên thanh thoát và tự tin hơn", "Trắng", 39, 230000, 3));
        Util.products.add(new Product(1002, "Giày Sneakers Unisex CLAE Bradley", R.drawable.pro2 + "", "Giày Sneakers Unisex NATIVE Ad Cornell", "Đỏ", 39, 330000, 5));
        Util.products.add(new Product(1003, "Giày Sneakers Unisex CLAE Bradley", R.drawable.pro2 + "", "Giày sneaker nam Clae Bradley với thiết kế thời trang sẽ giúp bạn tự tin thể hiện cá tính riêng biệt của mình, đế giày chống mòn, chống trơn trượt. ", "Đỏ", 38, 320000, 4));
        Util.products.add(new Product(1004, "Giày Sneakers Unisex CLAE Bradley", R.drawable.pro3 + "", "Giày Sneakers Unisex Clae Bradley được may từ chất liệu da cao cấp, đường may tỉ mỉ kết hợp thiết kế đơn giản, mang lại phong cách hiện đại và không kém phần nam tính cho phái mạnh. Đế giày có rãnh chống trơn trượt mang đến sự an toàn cho bạn trong suốt quá trình vận động. Sản phẩm dễ dàng phối hợp với nhiều loại trang phục và phụ kiện.", "Đen", 37, 499000, 7));
        Util.products.add(new Product(1005, "Giày Sneakers Unisex CLAE Bradley", R.drawable.pro4 + "", "Giày sneaker nam Clae Bradley với thiết kế thời trang sẽ giúp bạn tự tin thể hiện cá tính riêng biệt của mình, đế giày chống mòn, chống trơn trượt.", "Xanh", 38, 430000, 4));
        Util.products.add(new Product(1006, "Giày Sneakers Nam ADIDAS Court Adapt", R.drawable.pro5 + "", "Nâng tầm phong cách của bạn bên ngoài sân thi đấu. Mẫu giày lấy cảm hứng từ môn quần vợt này có kiểu dáng đẹp mắt được may từ vải dệt kim mềm mại.", "Đen", 39, 220000, 6));
        Util.products.add(new Product(1007, "Giày Sneakers Nam GEOX U Kaula D", R.drawable.pro6 + "", "Giày Sneakers nam GEOX U KAULA D NAPPA+SYNT.LEA WHITE/NAVY sở hữu kiểu dáng thời trang nhưng không kém phần hiện đại.", "Trắng", 39, 230000, 4));
        Util.products.add(new Product(1008, "Giày Sneakers Nam GEOX U Leitan D", R.drawable.pro7 + "", "Giày lười Leitan cho nam với thiết kế như một giày tây nhưng siêu nhẹ và thoáng khí, phù hợp với trang phục hàng ngày: Leitan nâng niu bàn chân với phần mũi giày rộng, không chỉ mang đến sự nhẹ nhàng, thoải mái và phong cách tinh tế trong lớp vải nappa đen.", "Đen", 40, 320000, 7));
        adapterProduct = new AdapterProduct(Util.products);


        adapterProduct.setItemOnclick(product -> {
            Intent intent1 = new Intent(MainActivity.this, ProductDetailActivity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putSerializable("detail", product);
            bundle1.putSerializable("user", user);
            intent1.putExtra("product", bundle1);
            startActivity(intent1);
        });
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 2, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterProduct);

        imgAvatar.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, AcountDetailActivity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putSerializable("user", user);
            intent1.putExtra("detail", bundle1);
            startActivity(intent1);
        });

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.menugiohang:
                    Intent intent1 = new Intent(MainActivity.this, ShoppingCartActivity.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putSerializable("user", user);
                    intent1.putExtra("bund", bundle1);
                    startActivity(intent1);
                    break;
                case R.id.menulogout:
                    Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.menuDonhang:
                    Intent intent3 = new Intent(MainActivity.this, donhang.class);
                    startActivity(intent3);
                    break;
                case R.id.menumessage:
                    Intent intent4 = new Intent(MainActivity.this, nhantin.class);
                    startActivity(intent4);
                    break;
                case R.id.menuperson:
                    break;

            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });

        imgSearch.setOnClickListener(view -> {
            String searchProduct = edSearch.getText().toString();
            List<Product> productSearch = new ArrayList<>();
            for (Product product : Util.products) {
                if (product.getName().contains(searchProduct)) {
                    productSearch.add(product);
                    RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(getBaseContext(), 2, LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(layoutManager1);
                    recyclerView.setAdapter(new AdapterProduct(productSearch));
                }
            }
        });
        imgCart.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, ShoppingCartActivity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putSerializable("user", user);
            intent1.putExtra("bund", bundle1);
            startActivity(intent1);
        });

        imgSort.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.sort_menu);
            popupMenu.setOnMenuItemClickListener(menuItem -> {
                switch (menuItem.getItemId()) {
                    case R.id.hight:
                        List<Product> list = Util.products;
                        list.sort((product, t1) -> {
                            if (product.getPrice() < t1.getPrice()) {
                                return 1;
                            } else if (product.getPrice() == t1.getPrice()) {
                                return 0;
                            } else return -1;
                        });
                        recyclerView.setAdapter(new AdapterProduct(list));
                        adapterProduct.notifyDataSetChanged();
                    case R.id.low:
                        List<Product> list1 = Util.products;
                        list1.sort((product, t1) -> {
                            if (product.getPrice() < t1.getPrice()) {
                                return -1;
                            } else if (product.getPrice() == t1.getPrice()) {
                                return 0;
                            } else return 1;
                        });
                        recyclerView.setAdapter(new AdapterProduct(list1));
                }
                return false;
            });
            popupMenu.show();
        });
        imgMenu.setOnClickListener(view -> {
            drawerLayout.openDrawer(Gravity.LEFT);
        });


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}