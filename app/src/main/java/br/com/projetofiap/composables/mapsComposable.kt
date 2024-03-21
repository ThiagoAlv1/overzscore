package br.com.projetofiap.composables

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.projetofiap.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.PinConfig
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.CameraPositionState

import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

val images = listOf(
    "https://w0.peakpx.com/wallpaper/324/121/HD-wallpaper-new-2023-movie-john-wick-4-poster-movie.jpg",
    "https://w0.peakpx.com/wallpaper/694/975/HD-wallpaper-oppenheimer-movie-2023.jpg",
    "https://w0.peakpx.com/wallpaper/640/109/HD-wallpaper-transformers-rise-of-the-beasts-movie-poster-2023.jpg",
    "https://w0.peakpx.com/wallpaper/542/826/HD-wallpaper-optimus-prime-dragon-movie-poster-transformers-transformers-5-transformers-last-knight.jpg"
)

@Composable
fun MapsComposable() {

    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }


    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
    ) {
        MarkerInfoWindow(
            state = MarkerState(singapore),
            icon = BitmapDescriptorFactory.fromResource(R.drawable.bola),
            infoWindowAnchor = Offset(0.5f, 5f)
        ) { marker ->
            Card(
                modifier = Modifier
                    .size(width = 340.dp, height = 500.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.Gray)
                        .fillMaxWidth()
                        .height(100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        marker.title ?: "Nome da quadra",
                    )
                    Text(text = "Endereço da quadra")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(painter = painterResource(id = R.drawable.quadra1) , contentDescription = "foto 1" , alignment = Alignment.Center  )
                    Image(painter = painterResource(id = R.drawable.quadra2) , contentDescription = "foto 2" , alignment = Alignment.Center)
                    Image(painter = painterResource(id = R.drawable.quadra3) , contentDescription = "foto 3" , alignment = Alignment.Center)
                }

            }
        }
    }
}












