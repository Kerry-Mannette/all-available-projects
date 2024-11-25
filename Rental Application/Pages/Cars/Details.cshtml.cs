using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Data;
using RazorPagesRental.Models;

namespace RazorPagesRental.Pages_Cars
{
    public class DetailsModel : PageModel
    {
        private readonly RazorPagesRental.Data.RazorPagesCarsContext _context;

        public DetailsModel(RazorPagesRental.Data.RazorPagesCarsContext context)
        {
            _context = context;
        }

        public Cars Cars { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var cars = await _context.Cars.FirstOrDefaultAsync(m => m.Id == id);

            if (cars is not null)
            {
                Cars = cars;

                return Page();
            }

            return NotFound();
        }
    }
}
