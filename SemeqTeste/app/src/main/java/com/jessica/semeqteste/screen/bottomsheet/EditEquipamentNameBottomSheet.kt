package com.jessica.semeqteste.screen.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jessica.semeqteste.R
import com.jessica.semeqteste.ui.SemeqDesignSystem
import com.jessica.semeqteste.ui.previews.Previews
import com.jessica.semeqteste.ui.theme.palette.pink
import com.jessica.semeqteste.ui.theme.palette.system
import com.jessica.semeqteste.ui.theme.palette.whiteSolid
import com.jessica.semeqteste.ui.unofficial.SimpleButtonComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditEquipmentNameBottomSheet(
    modifier: Modifier = Modifier,
    currentName: String,
    onDismissRequest: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var equipmentName by remember { mutableStateOf(currentName) }

    ModalBottomSheet(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        containerColor = SemeqDesignSystem.color.system.background.composeColor(),
        onDismissRequest = onDismissRequest,
        windowInsets = WindowInsets.systemBars,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SemeqDesignSystem.spacing.spacingSmall16),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(SemeqDesignSystem.spacing.spacingSmall16)
        ) {
            Text(
                text = stringResource(id = R.string.edit_equipment_name),
                style = SemeqDesignSystem.typography.baseStrong16,
            )

            TextField(
                value = equipmentName,
                onValueChange = { equipmentName = it },
                label = { Text(stringResource(id = R.string.edit_equipment_name)) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = SemeqDesignSystem.color.whiteSolid.scale700.composeColor()
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botões de Ação
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SimpleButtonComponent(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    text = stringResource(id = R.string.cancel),
                    backgroundColor = SemeqDesignSystem.color.whiteSolid.scale600.composeColor(),
                    textColor = SemeqDesignSystem.color.pink.scale500.composeColor(),
                    isEnabled = true,
                    onClick = onDismissRequest
                )

                Spacer(modifier = Modifier.width(16.dp))

                SimpleButtonComponent(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    text = stringResource(id = R.string.confirm),
                    backgroundColor = SemeqDesignSystem.color.pink.scale500.composeColor(),
                    textColor = SemeqDesignSystem.color.whiteSolid.scale600.composeColor(),
                    isEnabled = true,
                    onClick = { onConfirm(equipmentName) }
                )
            }
        }
    }
}

@Previews
@Composable
fun EditEquipmentNameBottomSheetPreview() {
    EditEquipmentNameBottomSheet(
        currentName = "Equipamento 1",
        onDismissRequest = {},
        onConfirm = {}
    )
}
