package com.jessica.semeqteste.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jessica.semeqteste.R
import com.jessica.semeqteste.data.datastore.DataStoreRepository
import com.jessica.semeqteste.domain.usecase.ApiUseCase
import com.jessica.semeqteste.domain.usecase.GetUserNameUseCase
import com.jessica.semeqteste.screen.bottomsheet.EditEquipmentNameBottomSheet
import com.jessica.semeqteste.ui.SemeqDesignSystem
import com.jessica.semeqteste.ui.previews.Previews
import com.jessica.semeqteste.ui.theme.palette.neutral
import com.jessica.semeqteste.ui.theme.palette.pink
import com.jessica.semeqteste.ui.theme.palette.system
import com.jessica.semeqteste.ui.theme.palette.whiteSolid

@Composable
internal fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val name = viewModel.name.collectAsState().value
    val tree = viewModel.tree.collectAsState().value
    val isLoading = tree.isEmpty()

    val treeMap = tree.groupBy { it.parent }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SemeqDesignSystem.color.pink.scale500.composeColor())
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = SemeqDesignSystem.spacing.spacingSmall20,
                    vertical = SemeqDesignSystem.spacing.spacingMedium64
                )
        ) {
            Text(
                text = stringResource(id = R.string.hello),
                style = SemeqDesignSystem.typography.baseStrong12,
                color = SemeqDesignSystem.color.whiteSolid.scale700.composeColor()
            )
            Text(
                text = name.uppercase(),
                style = SemeqDesignSystem.typography.baseStrong32,
                color = SemeqDesignSystem.color.whiteSolid.scale700.composeColor()
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(
                    color = SemeqDesignSystem.color.system.background.composeColor(),
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(SemeqDesignSystem.spacing.spacingSmall16)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 150.dp))
                    .background(SemeqDesignSystem.color.system.background.composeColor())
                .padding(top = SemeqDesignSystem.spacing.spacingMedium64, start = SemeqDesignSystem.spacing.spacingSmall16),
                contentAlignment = Alignment.TopCenter
            ) {

                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center),
                        color = SemeqDesignSystem.color.pink.scale500.composeColor()
                    )
                } else {
                    LazyColumn {
                        treeMap[null]?.let { setores ->
                            items(setores) { setor ->
                                FolderRow(name = setor.name)

                                IndentedContent {
                                    treeMap[setor.id]?.forEach { area ->
                                        FolderRow(name = area.name)

                                        IndentedContent {
                                            treeMap[area.id]?.forEach { conjunto ->
                                                FolderRow(name = conjunto.name, editable = true)

                                                IndentedContent {
                                                    treeMap[conjunto.id]?.forEach { sensor ->
                                                        SensorRow(name = sensor.name)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun FolderRow(
    name: String,
    editable: Boolean = false
) {
    var isBottomSheetOpen by remember { mutableStateOf(false) }
    var editedName by remember { mutableStateOf(name) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding( SemeqDesignSystem.spacing.spacingSmall4)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.folder_simple),
            contentDescription = null,
            tint =  SemeqDesignSystem.color.neutral.scale700.composeColor(),
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(SemeqDesignSystem.spacing.spacingSmall8))

        Text(
            text = editedName,
            style = SemeqDesignSystem.typography.baseRegular14,
            color = SemeqDesignSystem.color.neutral.scale700.composeColor(),
            modifier = Modifier.weight(1f)
        )

        if (editable) {
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                tint = SemeqDesignSystem.color.pink.scale500.composeColor(),
                modifier = Modifier
                    .size(18.dp)
                    .clickable { isBottomSheetOpen = true }
            )
        }

        if (isBottomSheetOpen) {
            EditEquipmentNameBottomSheet(
                currentName = editedName,
                onDismissRequest = { isBottomSheetOpen = false },
                onConfirm = { newName ->
                    editedName = newName
                    isBottomSheetOpen = false
                }
            )
        }
    }
}


@Composable
fun SensorRow(
    name: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = SemeqDesignSystem.spacing.spacingSmall4)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.sensor),
            contentDescription = null,
            tint = SemeqDesignSystem.color.neutral.scale700.composeColor(),
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = name,
            style = SemeqDesignSystem.typography.baseRegular14,
            color = SemeqDesignSystem.color.neutral.scale700.composeColor()
        )
    }
}

@Composable
fun IndentedContent(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.padding(start = 24.dp)
    ) {
        content()
    }
}

@Previews
@Composable
fun HomeScreenPreview() {
    val context = LocalContext.current
    val dataStore = DataStoreRepository(context)
    val getUserNameUseCase = GetUserNameUseCase(dataStore)
    val apiUseCase = ApiUseCase(dataStore)

    val viewModel: MockHomeScreenViewModel = viewModel(
        factory = MockHomeScreenViewModel.create(
            getUserNameUseCase,
            apiUseCase
        )
    )
    HomeScreen(viewModel)
}